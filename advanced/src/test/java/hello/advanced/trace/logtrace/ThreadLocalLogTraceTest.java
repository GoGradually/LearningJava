package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2(){
        TraceStatus traceStatus1 = trace.begin("hello1");
        TraceStatus traceStatus2 = trace.begin("hello2");
        trace.end(traceStatus2);
        trace.end(traceStatus1);
    }

    @Test
    void begin_exception_level2(){
        TraceStatus traceStatus1 = trace.begin("hello1");
        TraceStatus traceStatus2 = trace.begin("hello2");
        trace.exception(traceStatus2, new IllegalStateException());
        trace.exception(traceStatus1, new IllegalStateException());
    }

}