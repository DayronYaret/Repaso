package es.ulpgc.dayron.repaso.principal;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.dayron.repaso.app.AppMediator;
import es.ulpgc.dayron.repaso.app.Repository;
import es.ulpgc.dayron.repaso.app.RepositoryContract;

public class PrincipalScreen {

  public static void configure(PrincipalContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    PrincipalState state = mediator.getPrincipalState();
    RepositoryContract repository = Repository.getInstance(context.get());

    PrincipalContract.Router router = new PrincipalRouter(mediator);
    PrincipalContract.Presenter presenter = new PrincipalPresenter(state);
    PrincipalContract.Model model = new PrincipalModel(repository);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
