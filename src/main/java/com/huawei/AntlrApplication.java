package com.huawei;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.huawei.demo.HelloBaseListener;
import com.huawei.demo.HelloLexer;
import com.huawei.demo.HelloParser;

public class AntlrApplication {
	public static void main(String[] args) throws IOException {
		// CharStream oInput = CharStreams.fromStream(System.in);
		// BGCli2Lexer oLexer = new BGCli2Lexer(oInput);
		// CommonTokenStream oTokens = new CommonTokenStream(oLexer);
		// BGCli2Parser oParser = new BGCli2Parser(oTokens);
		// ParseTree oTree = oParser.r();
		// System.out.println(oTree.toStringTree(oParser));
		// ParseTreeWalker oWalker = new ParseTreeWalker();
		// oWalker.walk(new BGCli2BaseListener(), oTree);

		CharStream oInput = CharStreams.fromFileName(args[0]);
		HelloLexer lexer = new HelloLexer(oInput);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		HelloParser parser = new HelloParser(tokens);
		parser.setBuildParseTree(true); // tell ANTLR to build a parse tree
		ParseTree tree = parser.r();

		ParseTreeWalker walker = new ParseTreeWalker();
		HelloBaseListener listener = new HelloBaseListener();
		walker.walk(listener, tree);
		System.out.println(listener);
	}
}
