package dev.aisandbox.demo.twisty.easy.easycube333;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Finder {

  public static String getRegex(EdgePosition p) {
    switch (p) {
      case EDGE_TOP_FRONT : return ".......x...........y..................................";
      case EDGE_TOP_RIGHT: return ".....x......................y.........................";
      case EDGE_TOP_BACK: return ".x...................................y................";
      case EDGE_TOP_LEFT: return"...x......y...........................................";
      case EDGE_FRONT_TOP: return".......y...........x..................................";
      case EDGE_FRONT_RIGHT: return ".......................x......y.......................";
      case EDGE_FRONT_BOTTOM: return".........................x....................y.......";
      case EDGE_FRONT_LEFT:return"..............y......x................................";
      case EDGE_RIGHT_TOP:return ".....y......................x.........................";
      case EDGE_RIGHT_BACK:return "................................x......y..............";
      case EDGE_RIGHT_BOTTOM:return "..................................x...............y...";
      case EDGE_RIGHT_FRONT:return ".......................y......x.......................";
      case EDGE_LEFT_TOP:return "...y......x...........................................";
      case EDGE_LEFT_FRONT:return "..............x......y................................";
      case EDGE_LEFT_BOTTOM:return "................x...............................y.....";
      case EDGE_LEFT_BACK:return "............x............................y............";
      case EDGE_BOTTOM_FRONT : return ".........................y....................x.......";
      case EDGE_BOTTOM_RIGHT : return "..................................y...............x...";
      case EDGE_BOTTOM_BACK : return "...........................................y........x.";
      case EDGE_BOTTOM_LEFT : return "................y...............................x.....";
      case EDGE_BACK_TOP : return ".y...................................x................";
      case EDGE_BACK_LEFT : return "............y............................x............";
      case EDGE_BACK_BOTTOM : return "...........................................x........y.";
      case EDGE_BACK_RIGHT : return "................................y......x..............";
    }
    return null;
  }

  public static String getRegex(CornerPosition p) {
    switch (p) {
      case CORNER_FRONT_TOP_LEFT: return "......y....z......x...................................";
      case CORNER_TOP_LEFT_FRONT: return "......x....y......z...................................";
      case CORNER_LEFT_FRONT_TOP: return "......z....x......y...................................";

      case CORNER_FRONT_RIGHT_TOP: return "........z...........x......y..........................";
      case CORNER_RIGHT_TOP_FRONT: return "........y...........z......x..........................";
      case CORNER_TOP_FRONT_RIGHT: return "........x...........y......z..........................";

      case CORNER_RIGHT_BACK_TOP: return "..z..........................x......y.................";
      case CORNER_BACK_TOP_RIGHT: return "..y..........................z......x.................";
      case CORNER_TOP_RIGHT_BACK: return "..x..........................y......z.................";

      case CORNER_BACK_LEFT_TOP: return "z........y............................x...............";
      case CORNER_LEFT_TOP_BACK: return "y........x............................z...............";
      case CORNER_TOP_BACK_LEFT: return "x........z............................y...............";

      case CORNER_FRONT_BOTTOM_RIGHT: return "..........................x......z.............y......";
      case CORNER_BOTTOM_RIGHT_FRONT: return "..........................z......y.............x......";
      case CORNER_RIGHT_FRONT_BOTTOM: return "..........................y......x.............z......";

      case CORNER_FRONT_LEFT_BOTTOM: return ".................y......x....................z........";
      case CORNER_LEFT_BOTTOM_FRONT: return ".................x......z....................y........";
      case CORNER_BOTTOM_FRONT_LEFT: return ".................z......y....................x........";

      case CORNER_BACK_RIGHT_BOTTOM: return "...................................y......x..........z";
      case CORNER_RIGHT_BOTTOM_BACK: return "...................................x......z..........y";
      case CORNER_BOTTOM_BACK_RIGHT: return "...................................z......y..........x";

      case CORNER_BACK_BOTTOM_LEFT: return "...............z............................x......y..";
      case CORNER_BOTTOM_LEFT_BACK: return "...............y............................z......x..";
      case CORNER_LEFT_BACK_BOTTOM: return "...............x............................y......z..";

    }
    return null;
  }

  public static EdgePosition findEdge(String state, char prime, char second) {
    assert (state.indexOf('x') == -1);
    assert (state.indexOf('y') == -1);
    String target = state.replace(prime, 'x').replace(second, 'y');
    for (EdgePosition p : EdgePosition.values()) {
      if (target.matches(getRegex(p))) return p;
    }
    log.warn("Can't find edge {}-{} from state {}", prime, second, state);
    return null;
  }

  public static CornerPosition findCorner(String state, char prime, char second,char third) {
    assert (state.indexOf('x') == -1);
    assert (state.indexOf('y') == -1);
    assert (state.indexOf('z') == -1);
    String target = state.replace(prime, 'x').replace(second, 'y').replace(third, 'z');
    for (CornerPosition p : CornerPosition.values()) {
      if (target.matches(getRegex(p))) return p;
    }
    log.warn("Can't find corner {}-{}-{} from state {}", prime, second, third, state);
    return null;
  }
}
