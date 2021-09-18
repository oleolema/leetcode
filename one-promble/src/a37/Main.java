package a37;


import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 */
public class Main {

    public static class Codec {

        public static class Return {
            private TreeNode node;
            private int length;

            public Return(TreeNode node, int length) {
                this.node = node;
                this.length = length;
            }
        }


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root != null) {
                return  root.val + "L" + serialize(root.left) + "R" + serialize(root.right);
            }
            return "N";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return d(data, 0).node;
        }

        private Return d(String data, int start) {
            StringBuilder numStr = new StringBuilder();
            int i = start;
            for (; i < data.length(); i++) {
                char c = data.charAt(i);
                if ('0' <= c && c <= '9' || 'N' == c) {
                    numStr.append(c);
                } else {
                    break;
                }
            }
            System.out.println(numStr);
            if ("N".equals(numStr.toString())) {
                return new Return(null, 1);
            }
            TreeNode root = new TreeNode(Integer.parseInt(numStr.toString()));
            char c = data.charAt(i);
            System.out.println("c: " + data.charAt(i));
            Return returnL = d(data, i + 1);
            root.left = returnL.node;
            System.out.println("len: " + i + 2 + returnL.length);
            Return returnR = d(data, i + 2 + returnL.length);
            root.right = returnR.node;
            return new Return(root, numStr.length() + returnL.length + returnR.length);
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = createNode();
        System.out.println(codec.serialize(codec.deserialize("1L2L4L5LNRNR6LNRNRNR3LNRN")));
        System.out.println();
    }

    public static TreeNode createNode() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node5;
        node4.right = node6;
        return node1;
    }

}
