package com.hehe.Classic;
/**前缀树
 * 前缀树原型：可以查找是否有某个字符串前缀
 * 改进前缀树：是否添加过某字符串或有少个字符串以它为前缀 && 某个字符串的词频
 */
public class TrieTree_zs_difficult {

    public static class TrieNode {
        public int path;  //到达过该节点的字符串数量（是否添加过某字符串  或 有少个字符串以它为前缀）
        public int end;   //以该节点结尾的字符串数量（统计某字符串的词频）
//        public HashMap<Character,TrieNode> map; //
        public TrieNode[] nexts;  //路径上的数据（暂定26个字母  26条路）

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';  //chs[i]是a index为0  chs[i]是z index为25
                if (node.nexts[index] == null) { //没有节点 新建
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];   //node下跳一个节点
                node.path++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].path == 0) {  //如果当前结点的path为0，没有其他字符串经过该点了 直接后缀置空
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        /**
         * 查找出现某字符串的个数（词频）
         * @param word
         * @return
         */
        public int search(String word) {  //大体同insert
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        /**
         * 前缀数量的个数
         * @param pre
         * @return
         */
        public int prefixNumber(String pre) { //怎么插入 怎么找 返回node.path
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }

}
