package io.burt.jmespath.contrib.function;

import java.util.List;

import io.burt.jmespath.Adapter;
import io.burt.jmespath.JmesPathType;
import io.burt.jmespath.function.ArgumentConstraints;
import io.burt.jmespath.function.BaseFunction;
import io.burt.jmespath.function.FunctionArgument;

public class NormalizeSpaceFunction extends BaseFunction {
  /**
   * The zero-argument form of this function is not supported
   * since it is just a shorthand of using the current context
   * ('.' in XPath and '@' in JmesPath)
   */
  public NormalizeSpaceFunction() {
    super(ArgumentConstraints.typeOf(JmesPathType.STRING));
  }

  @Override
  protected <T> T callFunction(Adapter<T> runtime, List<FunctionArgument<T>> arguments) {
    T arg = arguments.get(0).value();
    return runtime.createString(runtime.toString(arg).replaceAll("\\s+", " ").trim());
  }
}
