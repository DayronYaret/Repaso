package es.ulpgc.dayron.repaso.app;

public interface RepositoryContract {
  void increase();
  int getCount();
  int getClick();
  void setCount(int count);
  void setClick(int click);
  void reset();
}
