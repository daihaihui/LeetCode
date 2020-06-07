package 二叉树;

import java.lang.reflect.Array;
import java.util.*;

public class 二叉树遍历 {

    public static class TreeNodeForpost {
        TreeNode node;
        int flag = 1;

        TreeNodeForpost(int flag, TreeNode node) {
            this.node = node;
            this.flag = flag;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode lr = new TreeNode(4);
        TreeNode rl = new TreeNode(5);
        TreeNode rr = new TreeNode(6);
        root.left = l;
        root.right = r;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        List<Integer> result = postorderTraversal(root);
        for (Integer integer : result) {
            System.out.printf(integer.toString()+",");
        }

    }


    //前序遍历递归
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.add(new Integer(root.val));
        if (root.left != null) list.addAll(preorderTraversal(root.left));
        if (root.right != null) list.addAll(preorderTraversal(root.right));
        return list;
    }

    //中序遍历递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left != null) list.addAll(inorderTraversal(root.left));
        list.add(new Integer(root.val));
        if (root.right != null) list.addAll(inorderTraversal(root.right));
        return list;
    }

    //后序遍历递归
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        if (root.left != null) list.addAll(postorderTraversal(root.left));
        if (root.right != null) list.addAll(postorderTraversal(root.right));
        list.add(new Integer(root.val));
        return list;
    }


    //前序遍历非递归
    public static List<Integer> preorderTraversal_norec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                list.add(new Integer(root.val));
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }

    //中序遍历非递归
    //定义一个栈，只要有左节点就一直入栈，否则就访问该节点，并压栈右节点
    public static List<Integer> inorderTraversal_norec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(new Integer(root.val));
                root = root.right;
            }
        }
        return list;
    }

    //后序遍历非递归
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        //保存已经出过栈的节点
        HashMap<TreeNode, Integer> map = new HashMap<>();

        //用于表示需不需要输出
        Stack<Integer> flag_stack = new Stack<Integer>();
        while (!(root == null &&stack.empty())) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.right == null || map.containsKey(root)) {
                    list.add(new Integer(root.val));
                    root=null;
                } else {
                    stack.push(root);
                    map.put(root, 0);
                    root = root.right;
                }
            }
        }
        return list;
    }
}
