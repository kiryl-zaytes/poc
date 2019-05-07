package sentence;

import com.sentence.Pair;
import com.sentence.Sentence;
import com.sun.media.sound.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;

/**
 * TestNg class to test basic behavior of longest word functionality;
 * Tests like return one of same length, buffer overflow, all of same length
 * could be added later when req are clear enough.
 */

public class SentenceTest {
    HashSet<Character> punc;

    @Test(groups = "default", description = "add more to force split")
    public void prepareSetOfPunctuation() {
        punc = new HashSet<Character>();
        punc.add('.');
        punc.add('!');
        punc.add(':');
        punc.add(' ');
        punc.add(',');
    }

    @Test(dependsOnGroups = {"default"})
    public void testLongestWordDefault() throws InvalidFormatException {
        Sentence sentence = new Sentence("The cow jumped over the moon.", punc);
        Assert.assertEquals(sentence.getLongestDefault(), new Pair(6,
                "jumped"));
    }

    @Test
    public void testLongestWord() throws InvalidFormatException {
        Sentence sentence = new Sentence("The cow jumped over the moon.");
        Assert.assertEquals(sentence.getLongest(), new Pair(6, "jumped"));
    }

    @Test
    public void testPunctuation() throws InvalidFormatException {
        Sentence sentence = new Sentence("The, cow jumped over the moon, " +
                "howthatcome!");
        Assert.assertEquals(sentence.getLongest(), new Pair(11, "howthatcome"));
    }

    @Test
    public void testSingleWord() throws InvalidFormatException {
        Sentence sentence = new Sentence("The!");
        Assert.assertEquals(sentence.getLongest(), new Pair(3, "The"));
    }

    @Test
    public void testSinglePunctuation() throws InvalidFormatException {
        Sentence sentence = new Sentence("!");
        Assert.assertEquals(sentence.getLongest(), new Pair(0, null));
    }

    @Test(expectedExceptions = InvalidFormatException.class)
    public void testNullWord() throws InvalidFormatException {
        String w = null;
        Sentence sentence = new Sentence(w);
    }

    @Test
    public void testOneChar() throws InvalidFormatException {
        Sentence sentence = new Sentence("a");
        Assert.assertEquals(sentence.getLongest(), new Pair(1, "a"));
    }

    @Test
    public void testOneMassivePattern() throws InvalidFormatException {
        Sentence sentence = new Sentence("a!!!!!!!!? bbb hello :::::");
        Assert.assertEquals(sentence.getLongest(), new Pair(5, "hello"));
    }

    @Test
    public void emptySequence() throws InvalidFormatException {
        Sentence sentence = new Sentence("                                 ");
        Assert.assertEquals(sentence.getLongest(), new Pair(0, null));
    }
}
