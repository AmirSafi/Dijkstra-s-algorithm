import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class TestGraph {
	MyGraph graph1;
	Collection<Edge> e;
	Collection<Vertex> v;
	Vertex ATL;
	Vertex ORD;
	Vertex DEN;
	Vertex IAH;
	Vertex IAD;
	Vertex MKC;
	Vertex LAX;
	Vertex JFK;
	Vertex SFO;
	Vertex SEA;
	Vertex IND;
	@Test
	public void vertexConstructor1() {;
		@SuppressWarnings("unused")
		Vertex v1 = new Vertex("ATL");
	}
	
	@Test
	public void vertexGetLabel() {;
		Vertex v1 = new Vertex("ATL");
		assertEquals("ATL", v1.getLabel());
	}
	@Test(expected = IllegalArgumentException.class)
	public void vertexConstructorException() {;
		@SuppressWarnings("unused")
		Vertex v2 = new Vertex(null);
	}
	
	@Test
	public void vertexHashCode() {;
		Vertex v1 = new Vertex("SEA");
		Vertex v2 = new Vertex("SEA");
		int code1 = v1.hashCode();
		int code2 = v2.hashCode();
		assertEquals(code1, code2);
	}
	
	@Test
	public void vertexEquals() {;
		Vertex v1 = new Vertex("IAD");
		Vertex v2 = new Vertex("IAD");
		assertTrue(v1.equals(v2));
	}
	
	@Test
	public void edgeConstructor1() {
		Vertex from = new Vertex("DEN");
		Vertex to = new Vertex("JFK");
		int weight = 10;
		@SuppressWarnings("unused")
		Edge e1 = new Edge(from, to ,weight);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void edgeConstructorException1() {
		Vertex from = null;
		Vertex to = new Vertex("JFK");
		int weight = 10;
		@SuppressWarnings("unused")
		Edge e1 = new Edge(from, to ,weight);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void edgeConstructorException2() {
		Vertex from = new Vertex("DEN");
		Vertex to = null;
		int weight = 10;
		@SuppressWarnings("unused")
		Edge e1 = new Edge(from, to ,weight);
	}
	
	@Test
	public void graphConstructor1() {
		Vertex from = new Vertex("DEN");
		Vertex to = new Vertex("JFK");
		int weight = 10;
		Collection<Edge> e = new ArrayList<Edge>();
		Collection<Vertex> v = new ArrayList<Vertex>();
		v.add(from);
		v.add(to);
		e.add(new Edge(from,to, weight));
		@SuppressWarnings("unused")
		MyGraph graph1 = new MyGraph(v, e); 
	}
	
	@Before
	public void graphConstructor2() {
		e = new ArrayList<Edge>();
		v = new ArrayList<Vertex>();
		//vertices 
		ATL = new Vertex("ATL");
		ORD = new Vertex("ORD");
		DEN = new Vertex("DEN");
		IAH = new Vertex("IAH");
		IAD = new Vertex("IAD");
		MKC = new Vertex("MKC");
		LAX = new Vertex("LAX");
		JFK = new Vertex("JFK");
		SFO = new Vertex("SFO");
		SEA = new Vertex("SEA");
		IND = new Vertex("IND");
		v.add(ATL);
		v.add(ORD);
		v.add(DEN);
		v.add(IAH);
		v.add(IAD);
		v.add(MKC);
		v.add(LAX);
		v.add(JFK);
		v.add(SFO);
		v.add(SEA);
		v.add(IND);
		e.add(new Edge(ATL,IAD, 143));
		e.add(new Edge(IAD,ATL, 125));
		e.add(new Edge(ATL,IND, 122));
		e.add(new Edge(IND,ATL, 120));
		e.add(new Edge(ATL,IAH, 174));
		e.add(new Edge(IAH,ATL, 170));
		e.add(new Edge(ORD,IND, 43));
		e.add(new Edge(IND,ORD, 45));
		e.add(new Edge(ORD,JFK, 189));
		e.add(new Edge(JFK,ORD, 190));
		e.add(new Edge(JFK,IAD, 46));
		e.add(new Edge(IAD,JFK, 49));
		graph1 = new MyGraph(v, e); 
	}
	
	@Test
	public void graphPrint() {
		System.out.println(graph1.edges());
		System.out.println(graph1.vertices());
		System.out.println(graph1.adjacentVertices(JFK));	
	}
	
	@Test
	public void graphEdgeCost() {
		assertEquals(graph1.edgeCost(ATL, IAD), 143);
	}
	
	@Test
	public void graphEdgeCos2() {
		assertEquals(graph1.edgeCost(IAD, JFK), 49);
	}
	
	@Test
	public void graphEdgeCostError() {
		assertEquals(graph1.edgeCost(ATL, SEA), -1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void graphConstNull() {
		@SuppressWarnings("unused")
		MyGraph graph1 = new MyGraph(null,null);
	}
}
