package com.chrislaforetsoftware.library.business.hold.repository;

import com.chrislaforetsoftware.library.business.catalog.entities.Title;
import com.chrislaforetsoftware.library.business.hold.entities.Hold;
import com.chrislaforetsoftware.library.domains.catalog.entities.ITitle;
import com.chrislaforetsoftware.library.domains.hold.entities.IHold;
import com.chrislaforetsoftware.library.domains.hold.repository.IHoldRepository;
import com.chrislaforetsoftware.library.domains.patron.entities.IPatron;
import com.chrislaforetsoftware.library.io.catalog.entities.Catalog;
import com.chrislaforetsoftware.library.io.catalog.repository.BookJpaRepository;
import com.chrislaforetsoftware.library.io.catalog.repository.CatalogJpaRepository;
import com.chrislaforetsoftware.library.io.patron.entities.Patron;
import com.chrislaforetsoftware.library.io.patron.repository.PatronJpaRepository;
import com.chrislaforetsoftware.library.io.titlehold.entities.TitleHold;
import com.chrislaforetsoftware.library.io.titlehold.repository.TitleHoldJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HoldRepository implements IHoldRepository {

	private final TitleHoldJpaRepository repository;
	private final PatronJpaRepository patronRepository;
	private final CatalogJpaRepository catalogRepository;

	@Autowired
	public HoldRepository(TitleHoldJpaRepository repository,
						  PatronJpaRepository patronRepository,
						  CatalogJpaRepository catalogRepository) {
		this.repository = repository;
		this.patronRepository = patronRepository;
		this.catalogRepository = catalogRepository;
	}

	@Override
	public List<IHold> getHoldsForPatron(IPatron patron) {
		final List<IHold> holds = new ArrayList<>();
		repository.findByPatronId(Integer.valueOf(patron.getId()))
				.forEach(holdRecord -> {
					Catalog catalog =
							catalogRepository.findByIsbn(holdRecord.getIsbn())
									.orElseThrow(() -> new IllegalStateException("ISBN for book hold cannot be found in catalog"));
					IHold.HoldType holdType = holdRecord.isClosedEnded() ? IHold.HoldType.CLOSED_ENDED : IHold.HoldType.OPEN_ENDED;
					holds.add(new Hold(holdRecord.getId(), patron, new Title(catalog.getIsbn(), catalog.getTitle(), catalog.getAuthor()), holdType));
				});
		return holds;
	}

	@Override
	public List<IHold> getHoldsForTitle(ITitle title) {
		final List<IHold> holds = new ArrayList<>();
		repository.findByIsbn(title.getISBN()).forEach(holdRecord -> {
			Patron patron = patronRepository.findById(holdRecord.getPatronId())
					.orElseThrow(() -> new IllegalStateException("Patron for book hold cannot be found"));
			IHold.HoldType holdType = holdRecord.isClosedEnded() ? IHold.HoldType.CLOSED_ENDED : IHold.HoldType.OPEN_ENDED;
			holds.add(new Hold(holdRecord.getId(),
					new com.chrislaforetsoftware.library.business.patron.entities.Patron(Integer.toString(patron.getId()),
						patron.getName(), patron.isResearcher() ? IPatron.PatronType.RESEARCHER : IPatron.PatronType.NONRESEARCHER),
					title,
					holdType));

		});
		return holds;
	}

	@Override
	public IHold addHold(ITitle title, IPatron patron) {
		TitleHold titleHold = new TitleHold();
		titleHold.setIsbn(title.getISBN());
		titleHold.setPatronId(Integer.valueOf(patron.getId()));
		titleHold.setClosedEnded(patron.getPatronType() == IPatron.PatronType.NONRESEARCHER);
		repository.save(titleHold);

		IHold.HoldType holdType = titleHold.isClosedEnded() ? IHold.HoldType.CLOSED_ENDED : IHold.HoldType.OPEN_ENDED;
		return new Hold(titleHold.getId(), patron, title, holdType);
	}
}
