package sizebst;


/**
 * Class SizeBST represents a Binary Search Tree that can also be used, for any integer j,
 *  to answer the question "how many numbers in the tree are less than or equal to j" in worst 
 *  case time h where h is the height of the tree (not the number of nodes).
 * 
 *  The actual nodes of the tree are of class SizeBSTN.  SizeBST represents the overall tree.
 *  IF instance variable rootNode is null, the tree is empty, otherwise rootNode is the root
 *  of the tree of SizeBSTN's
 * @author lou
 *
 */
public class SizeBST {
	SizeBSTN rootNode;

	public SizeBST(SizeBSTN root){
		rootNode =  root;
	}

	public String toString(){
		if (rootNode == null)
			return "(null)";
		else {
			return "("+ SizeBSTN.nodeString(rootNode) + ")";
		}
	}

	/**
	 * @param target the number to search for
	 * @return true iff target is in this tree
	 */
	public boolean search(int target){
		SizeBSTN ptr=rootNode;
		
		if(rootNode==null){
			return false;
		} 
		
		while(ptr!=null){
			if(ptr.data==target){ 		
				return true;
			}
			else if(ptr.data>target){ 	
				ptr=ptr.LSubtree;	
			}
			else{ 						
				ptr=ptr.RSubtree;
			}
	}
		return false;
	}

	/**
	 * insert newData into tree;  if already there, do not change tree
	 * @param newData int to insert
	 */
	public void insert(int newData){
		SizeBSTN current= SizeBSTN.getNode(rootNode,newData);
		SizeBSTN newNode= new SizeBSTN(newData);
		if(rootNode==null){
			rootNode=newNode;
		}
		if(current==null){
			return;
		}
		if(current.data==newData){
			return;
		}
		else{
			if(newNode.data>current.data){
				SizeBSTN.getNodeIncr(rootNode,newData);
				current.RSubtree=newNode;
				newNode.size=1;
			}
			else{
				SizeBSTN.getNodeIncr(rootNode,newData);
				current.LSubtree=newNode;
				newNode.size=1;
			}
		}
		
	}

	/**
	 * @return returns how many numbers in the tree are less than or equal to target.  Returns -1 if tree is empty
	 * @param target
	 */
	public int numLEq(int target){
		int count=0;
		SizeBSTN ptr=rootNode;
		
		if(rootNode==null){
		return -1; 
		}
		
		while(ptr!=null){
			if(ptr.data<=target){
				count+=ptr.size;
				ptr=ptr.RSubtree;
			}
			else if(ptr.data>target){
				ptr=ptr.LSubtree;		
			}
		}
		return count;
	}

	public static void main(String args []){
		SizeBST tree1 = new SizeBST(null);
		System.out.println("empty: "+tree1);
		tree1.insert(40);
		System.out.println("40 "+tree1);
	}
}
