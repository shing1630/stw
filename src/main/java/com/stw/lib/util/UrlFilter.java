package main.java.com.stw.lib.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class UrlFilter implements Serializable
{
  private static final long serialVersionUID = 1L;

  private static char[] specialChars = { '[', '\\', '^', '$', '.', '|', ' ', '*', '+', '(', ')' };

  private ArrayList<Pattern> include = new ArrayList<Pattern>();
  private ArrayList<Pattern> exclude = new ArrayList<Pattern>();

  public UrlFilter()
  {
  }

  public UrlFilter include(String pattern)
  {
    this.include.add(UrlFilter.generateExpression(pattern));
    return this;
  }

  public UrlFilter exclude(String pattern)
  {
    this.exclude.add(UrlFilter.generateExpression(pattern));
    return this;
  }

  public boolean matches(String uri)
  {
    boolean match = false;

    // check inclusions
    for (Pattern pattern : this.include)
    {
      match = match || pattern.matcher(uri).matches();
    }

    if (!match)
    {
      return match;
    }

    // check exclusions
    for (Pattern pattern : this.exclude)
    {
      match = match && !pattern.matcher(uri).matches();
    }
    return match;
  }

  private static Pattern generateExpression(String input)
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++)
    {
      char letter = input.charAt(i);
      if (letter == '*')
      {
        sb.append(".*");
      }
      else if (UrlFilter.contains(specialChars, letter))
      {
        sb.append("\\" + letter);
      }
      else
      {
        sb.append(letter);
      }
    }
    return Pattern.compile(sb.toString());
  }

  private static boolean contains(char[] array, char value)
  {
    if (array == null || array.length == 0)
    {
      return false;
    }

    for (int i = 0; i < array.length; i++)
    {
      char o = array[i];
      if (o == value)
      {
        return true;
      }
    }
    return false;
  }
}
