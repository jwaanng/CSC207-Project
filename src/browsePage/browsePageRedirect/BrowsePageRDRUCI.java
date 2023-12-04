package browsePage.browsePageRedirect;

import browsePage.swipe.*;

public class BrowsePageRDRUCI {

    private final BrowsePageRDRPresenter presenter;
    private final InitiateProfileSwiper swiper;


    public BrowsePageRDRUCI(
            BrowsePageRDRPresenter browsePageRDRPresenter,
            InitiateProfileSwiper initiateProfileSwiper
          ) {
        swiper = initiateProfileSwiper;
        presenter = browsePageRDRPresenter;


    }

    public void execute() {
        presenter.prepareSuccessView();
        swiper.execute();
    }
}
