package HTMLCheck;


import java.util.*;

/**
 * <pre>
 * File         HTMLManager.java
 * Project      HW #4: HTML Checker
 * Description  This class checks the syntax of HTML tags. It 
 *              stores the contents of an HTML page as a queue 
 *              of HTMLTags. It will also to fix invalid HTML 
 *              tags by using stacks and queues to figure out 
 *              whether the tags match and fix the mistakes it
 *              finds.
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, JGRASP
 * Date         8/4/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version     1.0.0
 * </pre>
 */
public class HTMLManager {

    private Queue<HTMLTag> tags;
    private Queue<HTMLTag> output = new LinkedList<>();
   
    public HTMLManager() {
        this.tags = new LinkedList<>();
    }
    
    public HTMLManager(Queue<HTMLTag> tags) {
        this.tags = tags;
    }
    
    public Queue<HTMLTag> getTags(){
        Queue<HTMLTag> localTags = new LinkedList<>();
        int len = tags.size();
        for (int i = 0; i < len; i++) {
            localTags.add(tags.peek());
            tags.add(tags.remove());
        }
        
        return localTags;
    }
    
    public void fixHTML() {
        Stack<HTMLTag> stackOpeningTags = new Stack<>();
        
        while (!tags.isEmpty()) {            
            HTMLTag tag = tags.remove();
            if(tag.isSelfClosing()){ // is a self closing tag
                output.add(tag);
            }
            else if(tag.isClosing()){ // is a closing tag
                if(!stackOpeningTags.isEmpty()){
                    output.add(stackOpeningTags.pop().getMatching());
                }
            }
            else if(tag.isOpening()){ // is an opening tag
                output.add(tag);
                stackOpeningTags.push(tag);
            }
        }
        
        while (!stackOpeningTags.isEmpty()) {
            output.add(stackOpeningTags.pop().getMatching());
        }
        
        while (!output.isEmpty()) {            
            tags.add(output.remove());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<HTMLTag> localTags = getTags();

        while (!localTags.isEmpty()) {
            sb.append(localTags.remove().toString().trim());
        }
        
        return sb.toString();
    }
}
/*
Paste the output from JGrasp here.
Altering output will earn you an automatic zero for the assignment.

 
  ----jGRASP exec: java -ea HTMLChecker
  ----   at: Aug 4, 2021 11:25:05 AM
  ----jGRASP wedge: pid for process is 4246  pids for wedge are 4244 and 4245.
  ----jGRASP wedge: CLASSPATH is ":.:::/Applications/jGRASP.app/Contents/Resources/jgrasp/extensions/classes".
  ----jGRASP wedge: working directory is /Users/robert/Projects/Java/stroedAtGithub/CS143/src/HTMLChecker
  ----jGRASP wedge2: actual command sent [/Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/bin/java -ea HTMLChecker].
 ===============================
 Processing tests/test3.html...
 ===============================
 HTML: <br /></p></p>
 Checking HTML for errors...
 HTML after fix: <br />
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test2.html...
 ===============================
 HTML: <a><a><a></a>
 Checking HTML for errors...
 HTML after fix: <a><a><a></a></a></a>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test5.html...
 ===============================
 HTML: <div><h1></h1><div><img /><p><br /><br /><br /></div></div></table>
 Checking HTML for errors...
 HTML after fix: <div><h1></h1><div><img /><p><br /><br /><br /></p></div></div>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test4.html...
 ===============================
 HTML: <div><div><ul><li></li><li></li><li></ul></div>
 Checking HTML for errors...
 HTML after fix: <div><div><ul><li></li><li></li><li></li></ul></div></div>
 ----> Result matches Expected Output!
 
 ===============================
 Processing tests/test1.html...
 ===============================
 HTML: <b><i><br /></b></i>
 Checking HTML for errors...
 HTML after fix: <b><i><br /></i></b>
 ----> Result matches Expected Output!
 
 ===============================
         All tests passed!
 ===============================
 
  ----jGRASP wedge: exit code for process is 0.
  ----jGRASP: operation complete.
 
  
*/