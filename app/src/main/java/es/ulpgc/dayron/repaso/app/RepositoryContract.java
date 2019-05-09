package es.ulpgc.dayron.repaso.app;

public interface RepositoryContract {
  interface OnIncreasedCallback{
    void getValueIncrease(int count);
  }
  void increase(RepositoryContract.OnIncreasedCallback callback);

  int getCount();
  int getClick();
  void setCount(int count);
  void setClick(int click);

  interface  OnResetCallback{
    void setReset();
  }
  void reset(RepositoryContract.OnResetCallback callback);
}
