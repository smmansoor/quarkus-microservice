package com.codewithmansoor.fallback;


import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class StockFallBack implements FallbackHandler<String> {

  @Override
  public String handle(ExecutionContext executionContext) {
    return "{\n"
        + "  \"USD\" : {\"15m\" : 8726.31, \"last\" : 8726.31, \"buy\" : 8726.31, \"sell\" : 8726.31, \"symbol\" : \"$\"}}";
  }
}
