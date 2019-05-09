package es.ulpgc.dayron.repaso.secundaria;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.repaso.app.RepositoryContract;

public class SecundariaPresenter implements SecundariaContract.Presenter {

  public static String TAG = SecundariaPresenter.class.getSimpleName();

  private WeakReference<SecundariaContract.View> view;
  private SecundariaViewModel viewModel;
  private SecundariaContract.Model model;
  private SecundariaContract.Router router;

  public SecundariaPresenter(SecundariaState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<SecundariaContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(SecundariaContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(SecundariaContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    SecundariaState state = router.getDataFromPreviousScreen();
    if (state != null) {
      viewModel.click=state.click;
      viewModel.data = Integer.toString(viewModel.click);
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    viewModel.data = model.fetchData();
    view.get().displayData(viewModel);

  }
  public void reset(){
    model.reset(new RepositoryContract.OnResetCallback() {
      @Override
      public void setReset() {
        viewModel.click = 0;
      }
    });

  }

}
