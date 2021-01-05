package leetcode;

/***
 * 
 * 
 * @author huangpan  use recursion
 *
 */

public class Swap_node_24 {
	public int value;
	public Swap_node_24 next;
	public Swap_node_24() {}
	public Swap_node_24(int data) {
		this.value = data;
		}
    public Swap_node_24(int val, Swap_node_24 next) {
    	this.value = val;
    	this.next = next;
    }
	

    //使用递归，第三层中该层的head=null，返回给第二层的head.next，相当于后面没有了 ，然后第二层的next.next指向第二层的head，相当于掉头了。
    //接上。然后返回第二层的next，第一层的head.next指向第二层传来的next，第一层的next.next指向第一层的head，最终返回next。
    // 递归的最小重复是：将上层的head末尾接null，然后然两个节点翻转。返回翻转好的头节点。
	public Swap_node_24 swapPairs(Swap_node_24 head) {
		//递归终结条件
        if(head == null || head.next == null){
            return head;
        }
        //处理当前层
        Swap_node_24 next = head.next;                    //这里就是选定了两个节点
        //进入下一层
        head.next = swapPairs(next.next);                 //依次选下面两个节点  ，最底层终结时给上层的head节点接null
        
        //处理上层
        next.next = head;                                 //上层节点翻转
        
        return next;                                     // 然后返回翻转后新的头节点

	}
	
	
	
	//插入一节点作为当前节点的下一个节点
	public void after(Swap_node_24 node) {
		while(this.next != null) {
			Swap_node_24 nextListNode = this.next;
			this.next = node;
			node.next = nextListNode;
		}
		if(this.next == null) {
			this.next = node;
		}
	}
	
	
	
//	//在节点末尾追加节点, 如果不把this当前节点赋值给另一个变量，而是直接改，则整个都会被修改，append后只会返回null前的最后一个节点
//	public Swap_node_24 append(Swap_node_24 node) {
//		while(true) {
//			if (this.next == null) { break; }
//			this.next = this.next.next;	
//	   }
//		this.next = node;
//		return this;
//    }
	
	
	//在节点末尾追加节点
	public Swap_node_24 append(Swap_node_24 node) {
		Swap_node_24 currentNode = this;
		while(true) {
			if(currentNode.next == null) { break; } 
			currentNode = currentNode.next;
		}
		currentNode.next = node;
		return this;
	}
	
	
	//显示所有节点信息
	public void show() {
		Swap_node_24 currentNode = this;
		while(true) {
			System.out.println("当前节点信息为: "+ currentNode.value+" ");                           //currentNode.value若是写成this.value 输出的是固定的该当前值
			currentNode = currentNode.next;
			//this  = this.next;         //会报错，this不是一个变量，解决办法就是将this赋值给一个变量
			if(currentNode == null) {
				System.out.println("已经达到末尾!!!!!!");	
				break;
			}
		}
		
	}
	
	
	//删除下一个节点
	public void removenext() {
		while(this.next != null) {
			Swap_node_24 nextNextNode = this.next.next;
			this.next = nextNextNode;
		}
		if (this.next == null) {
			System.out.println("无法删除，已到末尾!!!!!");
		}
	}
	
	
	
	
	//获取下一个节点
	public Swap_node_24 next() {
		return this.next;
	}
	
	//获取当前节点中的数据
	public int getData() {
		return this.value;
		
	}
	
	//判断当前节点是否为最后一个节点
	public boolean isLast() {
		return this.next == null;
	}
}
