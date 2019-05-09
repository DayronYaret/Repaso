package es.ulpgc.dayron.repaso.secundaria;

import java.lang.ref.WeakReference;

interface SecundariaContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(SecundariaViewModel viewModel);

  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();
    void reset();
  }

  interface Model {
    String fetchData();
    void reset();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(SecundariaState state);

    SecundariaState getDataFromPreviousScreen();
  }
}
