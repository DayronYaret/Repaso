package es.ulpgc.dayron.repaso.app;

import android.app.Application;

import es.ulpgc.dayron.repaso.principal.PrincipalState;
import es.ulpgc.dayron.repaso.secundaria.SecundariaState;

public class AppMediator extends Application {

  private PrincipalState principalState;
  private SecundariaState secundariaState;

  public AppMediator(){
    principalState = new PrincipalState();
    secundariaState = new SecundariaState();

  }

  public PrincipalState getPrincipalState() {
  return principalState;
  }

  public void setPrincipalState(PrincipalState state) {
  this.principalState=state;
  }

  public SecundariaState getSecundariaState() {
  return secundariaState;
  }

  public void setSecundariaState(SecundariaState state) {
  this.secundariaState=state;
  }
}
