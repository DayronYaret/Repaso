package es.ulpgc.dayron.repaso.principal;

import java.lang.ref.WeakReference;

interface PrincipalContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(PrincipalViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void increase();

    void goReset();
  }

  interface Model {
    String fetchData();

    void increase();

    int getCount();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(PrincipalState state);

    PrincipalState getDataFromPreviousScreen();
  }
}
