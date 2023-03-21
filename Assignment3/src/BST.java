import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class BST<T extends Comparable<T>> {

	private Node<T> root;
	private Comparator<T> comparator;

	public BST() {
		root = null;
	}

	public BST(Comparator<T> comparator) {
		root = null;
		this.comparator = comparator;
	}

	private static class Node<T> {
		T value;
		Node<T> left, right;

		Node(T value) {
			this.value = value;
		}
	}

	public void insert(T value) {
		root = insertRecursively(root, value);
		
	}

	private Node<T> insertRecursively(Node<T> node, T value) {

		if (node == null) {
			node = new Node<T>(value);
			return node;
		}
		
		if ( compare(value, node.value) < 0) {
			
			node.left = insertRecursively(node.left, value);
		} else if (compare(value, node.value) > 0) {
			node.right = insertRecursively(node.right, value);
		}

		return node;
	}

	public void remove(T value) {
        root = remove(root, value);
    }

    private Node<T> remove(Node<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (compare(value, node.value) < 0) {
            node.left = remove(node.left, value);
        } else if (compare(value, node.value) > 0) {
            node.right = remove(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node<T> minRight = findMin(node.right);
                node.value = minRight.value;
                node.right = remove(node.right, minRight.value);
            }
        }

        return node;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
	
	
    public boolean search(T value) {
        return searchRecursively(root, value);
    }

    private boolean searchRecursively(Node<T> root, T value) {
        if (root == null) {
            return false;
        }

        if (root.value.equals(value)) {
            return true;
        }

        if (compare(value, root.value) < 0) {
            return searchRecursively(root.left, value);
        } else {
            return searchRecursively(root.right, value);
        }
    }
    
    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    int size(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    int size() {
        return size(root);
    }

	
	private int compare(T o1, T o2) {
		if (comparator != null) {
			return comparator.compare(o1, o2);
		
		}
		return o1.compareTo(o2);
	}
	
	private class InorderIterator implements Iterator<T>{
        private Stack<Node<T>> stack;

        public InorderIterator() {
            stack = new Stack<>();
            pushLeftNodes(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public T next() {
            Node<T> node = stack.pop();
            pushLeftNodes(node.right);
            return node.value;
        }

        private void pushLeftNodes(Node<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    public Iterator<T> iterator() {
        return new InorderIterator();
    }

}
