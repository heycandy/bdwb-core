package com.chinasofti.ark.bdwb.core;

import com.chinasofti.ark.bdwb.core.node.NodeContext;
import com.chinasofti.ark.bdwb.core.stage.StageContext;

/**
 * Created by White on 2017/8/23.
 */
public class Main {

  public static void main(String[] args) {
    new StageContext().newBuilder()
        .addNode("mysql.read")
        .directive("mysql.read")
        .parameter("name", "value")
        .addNode("select")
        .directive("select")
        .parameter("name", "value")
        .addNode("filter")
        .directive("filter")
        .parameter("name", "value")
        .addNode("mysql.write")
        .directive("mysql.write")
        .parameter("name", "value")
        .use((prevNode, nextNode, next, err) -> {
          System.out.println(
              String.format("[I'm MidWare] %s, %s, %s, %s", prevNode, nextNode, next, err));
//          next.call();
        })
        .use((node, curr, next, err) -> {
          System.out.println(String.format("[I'm Hook] %s, %s, %s, %s", node, curr, next, err));
//          next.call();
        }, NodeContext.NODE_CYCLE.NODE_CYCLE_ALL)
        .build()
        .executor()
        .run();
  }

}
