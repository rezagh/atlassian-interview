package flatten;

import java.util.LinkedList;
import java.util.List;

import flatten.Tree.Leaf;
import flatten.Tree.Node;

//objective: flatten this tree.
public class MyFlattenTree<T> implements FlattenTree<T> {

	private Function<T,T> readLeaf = new Function<T, T>() {
		@Override
		public T apply(T p) {
			return p;
		}
	};
	
	private Function<Triple<Tree<T>>, Triple<Tree<T>>> readNode = 
			new Function<Triple<Tree<T>>, Triple<Tree<T>>>() {
		
		@Override
		public Triple<Tree<T>> apply(Triple<Tree<T>> p) {
			return p;
		}
	};
	
	
	private List<T> flattenInOrderR(Tree<T> tree, List<T> list) {
		if(tree == null) throw new IllegalArgumentException();
		
		if(tree.get().isLeft()) {
			list.add(tree.get().ifLeft(readLeaf));
			return list;
		}
		
		Triple<Tree<T>> branches = tree.get().ifRight(readNode);
		
		flattenInOrderR(branches.left(), list);
		flattenInOrderR(branches.middle(), list);
		flattenInOrderR(branches.right(), list);
		
		return list;
		
	}
	
	public List<T> flattenInOrder(Tree<T> tree) {
		return flattenInOrderR(tree, new LinkedList<T>());
	}
	
	public static void main(String... args) {
		Leaf<Integer> l4 = new Leaf<Integer>(4);
		Leaf<Integer> l5 = new Leaf<Integer>(5);
		Leaf<Integer> l9 = new Leaf<Integer>(9);
		Tree<Integer> t459 = new Node<Integer>(l4, l5, l9);
		
		Leaf<Integer> l1 = new Leaf<Integer>(1);
		Leaf<Integer> l6 = new Leaf<Integer>(6);
		
		Tree<Integer> tRoot = new Node<Integer>(l1, t459, l6);
		
		FlattenTree<Integer> flatten = new MyFlattenTree<Integer>();
		
		List<Integer> f = flatten.flattenInOrder(tRoot);
		
		System.out.print(f);

		Tree<Integer> tRoot2 = new Node<Integer>(l1, t459, null);
		
		flatten.flattenInOrder(tRoot2);
		
	}

}