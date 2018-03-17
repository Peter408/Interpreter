
package interpreter;

import interpreter.ByteCode.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes()  {
        program = new Program();
        try {
            while (byteSource.ready()) {
                StringTokenizer line = new StringTokenizer(byteSource.readLine());
                String codeClass = CodeTable.getClassName(line.nextToken());
                ByteCode bytecode = (ByteCode) (Class.forName("interpreter.ByteCode." + codeClass).newInstance());
                ArrayList<String> arr = new ArrayList<>();
                while (line.hasMoreTokens())
                    arr.add(line.nextToken());
                bytecode.init(arr);
                program.add(bytecode);
            }
              program.resolveAddrs(program);
        } catch(IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return program;
    }

}
