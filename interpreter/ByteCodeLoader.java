package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import interpreter.bytecode.*;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts.
     * Grab correct class name for the given bytecode from CodeTable
     * create an instance of the bytecode class name returned from code table.
     * Parse any additional arguments for the given bytecode and send them to
     * the newly created bytecode instance via the init function.
     */
    public Program loadCodes(){
        Program pg = new Program();
        ArrayList<String> args = new ArrayList<>();
        String line;// = byteSource.readLine();
        try{
            while ((line = byteSource.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(line);
                args.clear();
                String byteCodeClass = CodeTable.getClassName(token.nextToken());
                while (token.hasMoreTokens()) {
                    args.add(token.nextToken());
                }
                ByteCode byteCode = (ByteCode)(Class.forName("interpreter.bytecode." + byteCodeClass).newInstance());
                byteCode.init(args);
                pg.addCode(byteCode);
            }
        }catch (Exception x){}

        pg.resolveAddrs(pg);
        return pg;
    }
}
