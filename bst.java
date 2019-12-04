/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(rootNode==null){
   return null;
  }
 
  if(data==rootNode.getData()){
 
   if(rootNode.getLeft()!=null && rootNode.getRight()!=null){
     
    //Find Minimum from Right Tree OR find Maximum from Left Tree.
    Node minNode = getMinimumNodeFromRight(rootNode.getRight());
    rootNode.setData(minNode.getData());
 
    rootNode.setRight(deleteNode(rootNode.getRight(), minNode.getData()));
    System.out.println(minNode);
    
   }else if(rootNode.getLeft()==null){
    return rootNode.getRight();
   }else{
    return rootNode.getLeft();
   }
 
  }else if(data>rootNode.getData()){
   rootNode.setRight(deleteNode(rootNode.getRight(), data));
  }else{
   rootNode.setLeft(deleteNode(rootNode.getLeft(), data));
  }
 
  return rootNode;
 }
 
 public Node getMinimumNodeFromRight(Node node){
  if(node.getLeft()==null){
   return node;
  }else{
   Node n = getMinimumNodeFromRight(node.getLeft());
   return n;
  }
 }
    
 private void printTreeInOrder(Node rootNode){
  if(rootNode==null)
   return;
  printTreeInOrder(rootNode.getLeft());
  System.out.print(rootNode.getData() + " ");
  printTreeInOrder(rootNode.getRight());
 }
 
 private void addNode(Node rootNode, int data){
  if(rootNode==null){
   this.rootNode=new Node(data);
  }else{
   addNodeInProperPlace(rootNode, data);
  }
 }
  
 private void addNodeInProperPlace(Node rootNode, int data){ 
  if(data>rootNode.getData()){
   if(rootNode.getRight()!=null){
    addNode(rootNode.getRight(), data);
   }else{
    Node temp1 = new Node(data);
    rootNode.setRight(temp1);
   }
  }else{
   if(rootNode.getLeft()!=null){
    addNode(rootNode.getLeft(), data);
   }else{
    Node temp1 = new Node(data);
    rootNode.setLeft(temp1);
   }
  }
 }
    }
    
}