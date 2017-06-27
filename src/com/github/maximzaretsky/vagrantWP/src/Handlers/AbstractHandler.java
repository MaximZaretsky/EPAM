package vagrantWP.Handlers;

import vagrantWP.Tests.*;

/**
 * Created by Lenovo on 27.06.2017.
 */
public abstract class AbstractHandler {
  public AbstractHandler sucessor;
  public abstract ITest getTest(String commandAndParameters);
}
