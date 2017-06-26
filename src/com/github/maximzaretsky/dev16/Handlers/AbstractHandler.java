package Microframework.Handlers;

import Microframework.Commands.ICommand;

/**
 * Created by Aramorchi on 27.04.2017.
 */
public abstract class AbstractHandler {
  public AbstractHandler sucessor;
  public abstract ICommand getCommand(String commandAndParameters);
}
