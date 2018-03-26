package com.example.jc.myapplication.builder.normal;

import android.support.v7.app.AlertDialog;

/**
 * @author jc
 * @time 2018/3/26 上午10:18
 * @desc
 */

public class WaiterX {
  private WaiterController mWaiter;

  WaiterX() {
    mWaiter = new WaiterController();
  }



  public static class Builder {
    private WaiterController.AlertParams p;

    public Builder() {
      p = new WaiterController.AlertParams();
    }

    public Builder setFood(String food) {
      p.food = food;
      return this;
    }

    public Builder setDrink(String drink) {
      p.drink = drink;
      return this;
    }

    public Builder setCount(int count) {
      p.count = count;
      return this;
    }

    public Builder setType(int type) {
      p.type = type;
      return this;
    }

    public Builder setRemark(String remark) {
      p.remark = remark;
      return this;
    }

    public WaiterX create() {
      WaiterX waiter = new WaiterX();
      p.apply(waiter.mWaiter);
      return waiter;
    }

  }

  @Override public String toString() {
    return "WaiterX{" + "mWaiter=" + mWaiter + '}';
  }
}
