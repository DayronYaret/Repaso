package es.ulpgc.dayron.repaso.secundaria;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.dayron.repaso.app.RepositoryContract;

public class SecundariaModel implements SecundariaContract.Model {

  public static String TAG = SecundariaModel.class.getSimpleName();
  private RepositoryContract repository;
  public SecundariaModel(RepositoryContract repository) {
  this.repository=repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");

    return Integer.toString(repository.getClick());
  }

  @Override
  public void reset(RepositoryContract.OnResetCallback callback) {
    repository.reset(callback);
  }


}
