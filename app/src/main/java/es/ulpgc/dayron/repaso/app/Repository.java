package es.ulpgc.dayron.repaso.app;

import android.content.Context;

public class Repository implements RepositoryContract {
public static Repository INSTANCE;
private Context context;
private int count=0;
private int click=0;

public static RepositoryContract getInstance(Context context){
  if(INSTANCE == null){
    INSTANCE = new Repository(context);
  }
  return INSTANCE;
}
private Repository(Context context){
  this.context=context;
}

  @Override
  public void increase() {
    if(count == 9) {
      count = 0;
      click++;
    }
    else {
      count++;
      click++;
    }
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getClick() {
    return click;
  }

  public void setClick(int click) {
    this.click = click;
  }
  public void reset(){
  count =0;
  click = 0;
  }
}
