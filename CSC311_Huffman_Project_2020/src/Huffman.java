
import java.io.BufferedWriter;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
import java.awt.*;
import java.util.BitSet;



public class Huffman {
    static final boolean readFromFile = true;

    static PriorityQueue<Node> Nodes = new PriorityQueue<>((o1, o2) -> (o1.value < o2.value) ? -1 : 1);
    static TreeMap<Character, String> codes = new TreeMap<>();
    static String text = "";
    static String s = "";
    static String encoded = "";
    static String decoded = "";
    static int ASCII[] = new int[128];
    public Huffman(File f) throws FileNotFoundException {
    	
        Scanner s= new Scanner(f);
        long startTime = System.nanoTime();
        handleNewText(s);
        long endTime = System.nanoTime();
        long timeElapsed=endTime-startTime;
        System.out.println("the execution time is: "+timeElapsed/1000000+"ms");
        
        startTime = System.nanoTime();

        
        handleDNewText(s);
        endTime = System.nanoTime();
        timeElapsed=endTime-startTime;
        
        System.out.println("the execution time is after decoing is: "+timeElapsed/1000000+"ms");
    }
public Huffman() throws FileNotFoundException {
	
    }
public Huffman(String a) throws FileNotFoundException {
	

try {
	decodingText();
} catch (IOException e) {
	e.printStackTrace();
}
}

    public static void main(String[] args) throws FileNotFoundException {
    
    }


    /*
       private static void handleDecodingNewText(Scanner scanner) {
        System.out.println("Enter the text to decode: ");
        encoded = scanner.nextLine();
        System.out.println("Text to Decode: " + encoded);
        try {
		//	decodeText();
        	decodingText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    */

    private static boolean handleNewText(Scanner scanner) {
        System.out.println("Enter the text:");
        while(scanner.hasNextLine())
        text += scanner.nextLine();
        
            ASCII = new int[128];
            Nodes.clear();
            codes.clear();
            encoded = "";
            decoded = "";
            System.out.println("Text: " + text);
            calculateCharIntervals(Nodes, true);
            buildTree(Nodes);
            generateCodes(Nodes.peek(), "");

            printCodes();
            System.out.println("-- Encoding --");
            try {
				encodeText();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return false;



    }
    
    private static boolean handleDNewText(Scanner scanner) {
        System.out.println("Enter the text:");
        while(scanner.hasNextLine())
        text += scanner.nextLine();
        
            ASCII = new int[128];
            Nodes.clear();
            codes.clear();
            encoded = "";
            decoded = "";
            System.out.println("Text: " + text);
          
            System.out.println("-- Decoding --");
            try {
            	decodingText();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return false;



    }


    /*private static void decodeText() throws IOException {
        decoded = "";
        Node Node = Nodes.peek();
        for (int i = 0; i < encoded.length(); ) {
            Node tmpNode = Node;
            while (tmpNode.left != null && tmpNode.right != null && i < encoded.length()) {
                if (encoded.charAt(i) == '1')
                    tmpNode = tmpNode.right;
                else tmpNode = tmpNode.left;
                i++;
            }
            if (tmpNode != null)
                
                    decoded += tmpNode.character;
              

        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("decoded.txt"));
         		
         
         writer.write(decoded);
         writer.close();
         Desktop des= Desktop.getDesktop();
         File f0=new File("decoded.txt");
          des.open(f0);
        System.out.println("Decoded Text: " + decoded);
    }
    
  
*/
    private static void encodeText() throws IOException {
        encoded = "";
       
        for (int i = 0; i < text.length(); i++) {
            encoded+= codes.get(text.charAt(i));
            
        }
        encoded+="\n";
        BufferedWriter writer = new BufferedWriter(new FileWriter("Encoded.txt"));
        generateTreeCodes(Nodes.peek());
        String E="Encoded Message is: "+encoded;
        String T="The tree: 0"+s+"\n";
        String Tdescription="We start from the root, all 0s are internal nodes and all 1s are leaf nodes followee character. \n";

        String s1="the size before encoding is: "+text.length()+" bytes \n";

       String s2="the size after encoding is: "+encoded.length()/8+"."+encoded.length()%8+" bytes \n";
        		
        
        writer.write(E);
        writer.write(T);
        writer.write(Tdescription);
        
        writer.write(s1);
        writer.write(s2);

        writer.close();
        Desktop des= Desktop.getDesktop();
        File f0=new File("Encoded.txt");
         des.open(f0);
        System.out.println("Encoded Text: " + encoded);
        System.out.println(s1);
        System.out.println(s2);

    }
    
    private static void decodingText() throws IOException {
        decoded = "";
       int i = 0;
       String encodedMessage = "";
       String treeCode = "";
       
       i+=20;
        while(text.charAt(i) != 'T') {
        	encodedMessage += text.charAt(i++);
        }
    	System.out.println(encodedMessage);

        i += 10;
       
        while(text.charAt(i) != 'W') {
        	treeCode += text.charAt(i++);
        }
    	System.out.println(treeCode);

        
        int k = 0;
     
        for(int j =0; j<encodedMessage.length(); j++) {
      
        	if(encodedMessage.charAt(j) == '0') {
    			if(k<treeCode.length())
    				k++;
    			else k=0;
    			
        		if(treeCode.charAt(k) == '1') {
        			decoded += treeCode.charAt(k+1);
        			k=0;
        			continue;
        		}
        		else { 
        		continue;
        		}
        		
        	}
        	else {
        		int nbZeros = 0;
        		int nbOnes = 0;

        		for(; k< treeCode.length(); k++) {
        			
        			if(treeCode.charAt(k) == '0') 
        				nbZeros++;
            			
        				       			
        			 if(treeCode.charAt(k) == '1') {
        				nbOnes++;
        				k++;
        			
        		}
        			if(nbZeros == nbOnes) {
            			if(k<treeCode.length())
        				k++;
            			else k=0;
            	
        				break;
        		}
        			
        			
        		}
        		if(treeCode.charAt(k) == '1') {
        			decoded += treeCode.charAt(k+1);
        			k=0;
        			continue;
        		}
        		else {
        			continue;
        		}
        	  
        	}
        }        
        
        decoded+="\n";
        BufferedWriter writer = new BufferedWriter(new FileWriter("Decoded.txt"));
     
        writer.write(decoded);
        writer.close();
        Desktop des= Desktop.getDesktop();
        File f0=new File("Decoded.txt");
         des.open(f0);
        System.out.println("decoded Text: " + decoded);
    
    }
  

    private static void buildTree(PriorityQueue<Node> vector) {
    	int c=1;
        while (vector.size() > 1) {
        	Node n2 = vector.poll();
        	n2.setcount(c);
        	c++;
        	Node n = vector.poll();
        	n.setcount(c);
        	c++;
            vector.add(new Node(n,n2));
            
        }
        
    }

    private static void printCodes() {
        System.out.println("-- Printing Codes --");
    	System.out.println("Character :    Code");

        codes.forEach((k, v) -> System.out.println("   '" + k + "'    :    "+ v));
    }

    private static void calculateCharIntervals(PriorityQueue<Node> vector, boolean printIntervals) {
        if (printIntervals) {
        	System.out.println("--    intervals    --");
        	System.out.println("Character : Frequency");
        }

        for (int i = 0; i < text.length(); i++)
            ASCII[text.charAt(i)]++;
            
        for (int i = 0; i < ASCII.length; i++)
            if (ASCII[i] > 0) {
                vector.add(new Node(ASCII[i], ((char) i) ));
                if (printIntervals)
                    System.out.println("   '" + ((char) i) + "'    :    "+ASCII[i]);
            }
        
    }
    
    
    private static void generateTreeCodes(Node Node) {
        if(Node == null) {
        	return;
        }
     
        	if(Node.left.left!= null) {
        		s+="0";
        	generateTreeCodes(Node.left);
        	}
        	else
        		s+="1"+Node.left.character;
        	
        	if(Node.right.right!= null) {
        		s+="0";
        	generateTreeCodes(Node.right);
        	}
        	else
        		s+="1"+Node.right.character;
        
       
        	
        
    }
    

    private static void generateCodes(Node Node, String s) {
        if (Node != null) {
            if (Node.right != null)
                generateCodes(Node.right, s + "1");

            if (Node.left != null)
                generateCodes(Node.left, s + "0");

            if (Node.left == null && Node.right == null)
                codes.put(Node.character, s);
        }
    }
}