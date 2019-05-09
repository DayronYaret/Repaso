package es.ulpgc.dayron.repaso.principal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.dayron.repaso.R;

public class PrincipalActivity
    extends AppCompatActivity implements PrincipalContract.View {

  public static String TAG = PrincipalActivity.class.getSimpleName();

  private PrincipalContract.Presenter presenter;
  private TextView  data;
  private Button increaseButton, resetButton;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_principal);

    // do the setup
    PrincipalScreen.configure(this);
    data = findViewById(R.id.data);
    increaseButton = findViewById(R.id.IncreaseButton);
    resetButton = findViewById(R.id.resetButton);

    increaseButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.increase();
      }
    });
    resetButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.goReset();
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
  public void injectPresenter(PrincipalContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(PrincipalViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }
}
