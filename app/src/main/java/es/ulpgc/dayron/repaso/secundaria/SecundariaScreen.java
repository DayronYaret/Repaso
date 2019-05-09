package es.ulpgc.dayron.repaso.secundaria;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.dayron.repaso.app.AppMediator;
import es.ulpgc.dayron.repaso.app.Repository;
import es.ulpgc.dayron.repaso.app.RepositoryContract;

public class SecundariaScreen {

  public static void configure(SecundariaContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    SecundariaState state = mediator.getSecundariaState();
    RepositoryContract repository = Repository.getInstance(context.get());

    SecundariaContract.Router router = new SecundariaRouter(mediator);
    SecundariaContract.Presenter presenter = new SecundariaPresenter(state);
    SecundariaContract.Model model = new SecundariaModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
