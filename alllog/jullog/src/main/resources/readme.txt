java.util.logging是JDK自带的日志记录包。
默认情况下，JDK的LogManager会在JRE目录下的"lib/logging.properties"这个文件中读取配置。
JDK的日志包涉及handler,formatter,level
名词	    描述
handler	    将日志信息记录到指定的流之中，可能是控制台或者是一个文件或者是任意存储区域。常用实现类 ConsoleHandler, FileHandler, SocketHandler
formatter	日志信息格式化类。常用实现类 SimpleFormatter, XMLFormatter
level	    日志记录级别。SEVERE（最高值） 、WARNING 、INFO 、CONFIG 、FINE 、FINER 、FINEST（最低值）ALL(记录所有信息)  OFF(不记录任何级别信息)