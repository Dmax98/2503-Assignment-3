

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BST<T extends Comparable<T>> implements Iterable<T> {
	class BSTNode implements Comparable<BSTNode> {
		private T data;
		private BSTNode left;
		private BSTNode right;

		public BSTNode(T d) {
			setLeft(null);
			setRight(null);
			setData(d);
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public BSTNode getLeft() {
			return left;
		}

		public void setLeft(BSTNode left) {
			this.left = left;
		}

		public BSTNode getRight() {
			return right;
		}

		public void setRight(BSTNode right) {
			this.right = right;
		}

		public boolean isLeaf() {
			return (getLeft() == null) && (getRight() == null);
		}

		@Override
		public int compareTo(BST<T>.BSTNode o) {
			return this.getData().compareTo(o.getData());
		}

		public void isEmpty() {
			left = null;
			right = null;
			size = 0;

		}
	}

	private static final int INORDER = 0;
	private static final int PREORDER = 1;
	private static final int POSTORDER = 1;

	private BSTNode root;
	private int size;
	private Comparator<T> comparator;
	private Queue<T> queue = new LinkedList<T>();
	
	public BST() {
		root = null;
		size = 0;
		comparator = null;
	}
	
	public BST(Comparator<T> externalComp) {
		root = null;
		size = 0;
		comparator = externalComp;
	}

	public int size() {
		return size;
	}
	
	public void deleteNode(T key) {
        root = deleteNode(root, key);
    }

	private int height(BSTNode r) {
		int h = -1;
		if (r == null) {
			return h;
		} else {
			int leftHeight = height(r.getLeft());
			int rightHeight = height(r.getRight());
			h = Math.max(leftHeight, rightHeight) + 1;
		}
		return h;
	}

	public int height() {
		return height(root);
	}

	public void add(T d) {
		BSTNode n = new BSTNode(d);
		if (root == null) {
			size++;
			root = n;
		} else {
			add(root, n);
		}
	}

	private void add(BSTNode r, BSTNode n) {
		int c = n.compareTo(r);
		if (c < 0) {
			if (r.getLeft() == null) {
				r.setLeft(n);
			} else
				add(r.getLeft(), n);
		} else {
			if (r.getRight() == null)
				r.setRight(n);
			else {
				add(r.getRight(), n);
			}
		}
	}
	
	private BSTNode deleteNode(BSTNode node, T key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteNode(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                BSTNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.data = temp.data;
                node.right = deleteNode(node.right, temp.data);
            }
        }

        return node;
    }

	private void visit(BSTNode r) {
		if (r != null)
			queue.add(r.getData());
	}

	private void traverseInOrder(BSTNode r) {
		if (r != null)
			return;
		else {
			traverseInOrder(r.getLeft());
			visit(r);
			traverseInOrder(r.getRight());
		}
	}

	private void traversePreOrder(BSTNode r) {
		if (r != null)
			return;
		else {
			visit(r);
			traversePreOrder(r.getLeft());
			traversePreOrder(r.getRight());
		}
	}
	
	private void traversePostOrder(BSTNode r) {
		if(r != null)
			return;
		else {
			traversePostOrder(r.getLeft());
			traversePostOrder(r.getRight());
			visit(r);
		}
	}

	private void traverse(BSTNode r, int travType) {
		if (travType == INORDER) {
			traverseInOrder(r);
		} else if (travType == PREORDER) {
			traversePreOrder(r);
		} else if (travType == POSTORDER) {
			traversePostOrder(r);
		}
	}

	private class BSTIterator implements Iterator {
		public BSTIterator() {
				queue.isEmpty();
				traverse(root, INORDER);
			}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public T next() {
			return queue.remove();
		}
	}

	@Override
	public Iterator<T> iterator() {
		Iterator it = new BSTIterator();
		return  it;
	}

}
