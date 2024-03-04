
Logger sanLogger = new SanitizedTextLogger(logger);
 
if (loginSuccessful) {
  sanLogger.severe("User login succeeded for: " + username);
} else {
  sanLogger.severe("User login failed for: " + username);
}
class SanitizedTextLogger extends Logger {
    Logger delegate;
   
    public SanitizedTextLogger(Logger delegate) {
      super(delegate.getName(), delegate.getResourceBundleName());
      this.delegate = delegate;
    }
   
    public String sanitize(String msg) {
      Pattern newline = Pattern.compile("\n");
      Matcher matcher = newline.matcher(msg);
      return matcher.replaceAll("\n  ");
    }
   
    public void severe(String msg) {
      delegate.severe(sanitize(msg));
    }
   
    // .. Other Logger methods which must also sanitize their log messages
  }