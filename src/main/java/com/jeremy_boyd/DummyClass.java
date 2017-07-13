package com.jeremy_boyd;

import java.util.Objects;

class DummyClass {
  private String s;

  DummyClass(String s) {
    this.s = Objects.requireNonNull(s);
  }
}
