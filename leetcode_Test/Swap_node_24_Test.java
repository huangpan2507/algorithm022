package leetcode_Test;

import java.util.stream.IntStream;

import leetcode.Swap_node_24;


public class Swap_node_24_Test{
	public static void main(String[] args) {
		Swap_node_24 node = new Swap_node_24(0);
		Swap_node_24 node1 = new Swap_node_24(1);
		IntStream.range(2,5).forEach(i->node1.append(new Swap_node_24(i)));
		node1.show();
		Swap_node_24 node2 = node.swapPairs(node1);
		node2.show();
	}
}