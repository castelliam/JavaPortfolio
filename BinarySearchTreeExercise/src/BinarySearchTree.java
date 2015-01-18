// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

//author: Alex Castelli
//February 22, 2013
//CS230 TTh 1050-1205

import java.util.*;

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the tree.
     */
    public BinarySearchTree( )
    {
        root = null;
    }

    /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     * directs to insert method with actual code
     */
    public void insert( AnyType x , boolean b)
    {
        root = insert( x, b, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     * directs to deleted method with actual code
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     * @throws UnderflowException
     * directs to findMin method with recursion code
     */
    public AnyType findMin( ) throws UnderflowException
    {
    	if( isEmpty( ) ) throw new UnderflowException( );
           // throw new UnderflowException( );
        return findMin( root ).element;
    	/*try{
    		if( isEmpty( ) ) throw new UnderflowException( );
    	}
    	catch(UnderflowException e){
    		return (AnyType) new BinaryNode<AnyType>();
    	}
           // throw new UnderflowException( );
        return findMin( root ).element;*/
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     * @throws UnderflowException
     * directs to findMax method with recursion code 
     */
    public AnyType findMax( ) throws UnderflowException
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMax( root ).element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     * directs to contains method with actual code
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty by nulling out the tree
     */
    public void makeEmpty( )  //FINSIHED
    {
        root = null;
    }

    /**
     * checks to see if tree has any nodes
     * directs to isEmpty method with actual code
     * @return true if empty, false otherwise
     */
    public boolean isEmpty()
    {
        return isEmpty( root );
    }
    
    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( BinaryNode<AnyType> t )
    {
    	if(t == null) return true;
    	else if(t != null && t.deleted){ //only added t.deleted to make sure the node wasn't deleted
                isEmpty( t.left );
                isEmpty( t.right );
           }
    	else
    	{
    		return false;
    	}
    	return true;
    }

    /**
     * Print the tree contents in sorted order.
     * directed to method printTree with actual code
     */
    public void printTree( )
    {
        if( isEmpty(root) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     * have it so that if the value is already there but is shown as deleted, it changes the deleted from true to false
     * it does not input multiple nodes of the same value, there is just 1 of every value
     */
    private BinaryNode<AnyType> insert( AnyType x, boolean b, BinaryNode<AnyType> t)
    {
        if( t == null )
            return new BinaryNode<AnyType>( x, null, b, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, b, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, b, t.right );
        else
            t.deleted = false;  // Duplicate; changes deleted to false
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     * rather than setting the elements to findMin and setting the right, made the deleted = true
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
        	t.deleted = true;
            //t.element = findMin( t.right ).element;
            //t.right = remove( t.element, t.right );
        }
        else{
        	t.deleted = true;
        }
            //t = ( t.left != null ) ? t.left : t.right; //if t.left isn't null, it chooses t.left
        return t;
    }
    

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t)
    {
    	   if (t == null) return null; //empty tree
    	 
    	   BinaryNode<AnyType> min = findMin(t.left);
    	 
    	   if (min != null) return min;
    	   if (!t.deleted) return t; //if deleted is false, it's okay to return that value
    	 
    	   return findMin(t.right); //has to check right in case left node is deleted and doesn't have left children
    }
    
    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t)
    {
    	   if (t == null) return null; //empty tree
    	 
    	   BinaryNode<AnyType> max = findMax(t.right);
    	 
    	   if (max != null) return max;
    	   if (!t.deleted) return t; //if deleted is false, it's okay to return that value
    	 
    	   return findMax(t.left); //has to check left in case right node is deleted and doesn't have children
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
        {
        	if(t.deleted) return false; //if deleted, then that node technically does not exist, so return false
        	else return true;    // Match
        }
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.left );
            System.out.println( t.element + " - " + t.deleted); //added t.deleted to check if program was working
            printTree( t.right );
        }
    }

    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, false, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, boolean b, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
            deleted  = b; //added deleted for lazy deletion
        }

        AnyType element;            // The data in the node
        Boolean deleted;			// boolean for lazy deletion
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


      /** The tree root. */
    private BinaryNode<AnyType> root;
    
    
    /*************************************************
     * diplayTree( ) prints contents of tree
     *   by level: node (root) at depth 0
     *				nodes at depth 1
     *				nodes at depth 2
     *				etc.
     */
     
     /** 
      * Output all nodes, level by level
      */ 
     public void displayTree() //FINISHED
     {
     	  System.out.println("The tree contains:\n");
         displayLevel(root);
     }
     
     /** 
      * Output all nodes, level by level
      * 
      */
     private void displayLevel(BinaryNode node)
     {
         if (node == null)
            System.out.print(" - ");
         else
         {
           //Queue that holds the nodes on the current level
           Queue<BinaryNode> thisLevel = new LinkedList<BinaryNode>();
           //Queue that holds the nodes on the current level
           Queue<BinaryNode> nextLevel = new LinkedList<BinaryNode>(); 
           //put the root on the current level's queue
           thisLevel.add(node);
           int h = height(root);
           int levelTotal = 0;  //keeps track of the total levels printed so we don't  pass the height and print a billion "null"s
           while(!thisLevel.isEmpty()&& (levelTotal<= h))
           {

               while (!thisLevel.isEmpty())
               {
                  if (thisLevel.peek() != null)
                  {
                     if(!thisLevel.peek().deleted)System.out.print(thisLevel.peek().element + " ");
                     // if there is a left pointer , put on next level; if none, put a null
                     node = thisLevel.peek().left; // look at the left pointer of node
                     nextLevel.add(node); 
                     node = thisLevel.remove().right; // get right pointer and remove node
                     nextLevel.add(node); 
                  }
                  else
                  {
                     System.out.print(" - ");
                     nextLevel.add(null); 
                     nextLevel.add(null);
                     thisLevel.remove();
                  }
               }   
               while (!nextLevel.isEmpty())
               {
                     thisLevel.add(nextLevel.remove());
               }
               System.out.println();
               levelTotal++;
           }
         System.out.println();
       }
     }
     
     // Test program
	 public static void main( String [ ] args ) throws UnderflowException
	 {
	     BinarySearchTree<Integer> t = new BinarySearchTree<Integer>( );
	     final int NUMS = 20; //4000;
	     final int GAP  =   3; //37;
	
	     //System.out.println( "Checking... (no more output means success)" );
	
	     for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
	         t.insert( i, false );
	
	     /*for( int i = 1; i < NUMS; i+= 2 )
	         t.remove( i );
	
	     if( NUMS < 40 )
	         t.printTree( );
	     if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
	         System.out.println( "FindMin or FindMax error!" );
	
	          if( !t.contains( i ) )
	              System.out.println( "Find error1!" );
	
	     for( int i = 1; i < NUMS; i+=2 )
	     {
	         if( t.contains( i ) )
	             System.out.println( "Find error2!" );
	     }*/
	     
	     //t.displayTree();
	     
	     System.out.println();
	     
	     t.remove(12);
	     t.remove(1);
	     t.remove(2);
	     //t.remove(3);
	     //t.remove(19);
	     t.remove(30);
	     t.remove(18);
	     t.remove(17);
	     t.remove(16);
	     
	     t.printTree();
	     
	     System.out.println("Return true for t.contains(4): " + t.contains(4));
	     System.out.println("Return false for t.contains(1): " + t.contains(1));
	     System.out.println("Return false for t.contains(12): " + t.contains(12));
	     System.out.println("Return false for t.contains(3): " + t.contains(3));
	     System.out.println("Return false for t.contains(19): " + t.contains(19));
	     System.out.println("Return false for t.contains(30): " + t.contains(30));
	     System.out.println("Return true for t.contains(18): " + t.contains(18));
	     
	    // t.displayTree();
	     
	     System.out.println("t.findMax() should output 19: " + t.findMax());
	     System.out.println("t.findMin() should output 3: " + t.findMin());
	     
	     System.out.println("Testing insert new values and existing deleted");
	     t.insert(19, false);
	     t.insert(1, false);
	     t.insert(20, false);
	     t.insert(0, false);
	     t.insert(3, false);
	     
	     t.printTree();
	     
	     //t.printTree();
	     
	     System.out.println("Testing isEmpty() should be false: " + t.isEmpty());
	     
	     t.makeEmpty();
	     System.out.println("Testing isEmpty() should be true: " + t.isEmpty());
	     //t.printTree();
	     
	     //t.displayTree();
	 }
}
