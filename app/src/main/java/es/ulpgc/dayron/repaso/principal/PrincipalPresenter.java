package es.ulpgc.dayron.repaso.principal;

import android.util.Log;

import java.lang.ref.WeakReference;

public class PrincipalPresenter implements PrincipalContract.Presenter {

  public static String TAG = PrincipalPresenter.class.getSimpleName();

  private WeakReference<PrincipalContract.View> view;
  private PrincipalViewModel viewModel;
  private PrincipalContract.Model model;
  private PrincipalContract.Router router;

  public PrincipalPresenter(PrincipalState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<PrincipalContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(PrincipalContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(PrincipalContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    PrincipalState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    viewModel.data= model.fetchData();
    view.get().displayData(viewModel);

  }

  @Override
  public void increase() {
    model.increase();
    viewModel.count = model.getCount();
    viewModel.data = Integer.toString(viewModel.count);
    fetchData();
  }

  @Override
  public void goReset() {
    router.navigateToNextScreen();
  }


}
