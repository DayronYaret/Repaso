package es.ulpgc.dayron.repaso.principal;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

import es.ulpgc.dayron.repaso.app.RepositoryContract;

public class PrincipalModel implements PrincipalContract.Model {

  public static String TAG = PrincipalModel.class.getSimpleName();
  private RepositoryContract repository;
  private int count;
  private int click;
  public PrincipalModel(RepositoryContract repository) {
  this.repository = repository;
  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return Integer.toString(repository.getCount());
  }

  @Override
  public void increase() {
    repository.increase();
    count = repository.getCount();
    click = repository.getClick();
  }

  @Override
  public int getCount() {
    return count;
  }
}
