package es.ulpgc.dayron.repaso.secundaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.dayron.repaso.R;

public class SecundariaActivity
    extends AppCompatActivity implements SecundariaContract.View {

  public static String TAG = SecundariaActivity.class.getSimpleName();

  private SecundariaContract.Presenter presenter;
  private Button resetButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_secundaria);

    // do the setup
    SecundariaScreen.configure(this);
    resetButton= findViewById(R.id.resetActionButton);
    resetButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.reset();
        finish();
      }
    });
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(SecundariaContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(SecundariaViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }

}
