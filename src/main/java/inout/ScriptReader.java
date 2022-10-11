package inout;

import fpinjava.Result;
import list.List;
import tuple.Tuple;

import static list.List.list;

public class ScriptReader implements Input {

    private final List<String> commands;

    public ScriptReader(String... comms) {
        super();
        commands = list(comms);
    }


    @Override
    public Result<Tuple<String, Input>> readLine() {

        return commands.isEmpty() ? Result.failure("Not enough Entries") : Result.success(new Tuple<>(commands.headOption()
                .getOrElse(""), new ScriptReader(String.valueOf(commands.drop(1)))));
    }

    @Override
    public Result<Tuple<Integer, Input>> readInt() {
        try {
            return commands.isEmpty() ? Result.failure("Not enough Entries")
                    : Integer.parseInt(commands.headOption().getOrElse("")) >= 0
                        ? Result.success(new Tuple<>(Integer.parseInt(commands.headOption()
                         .getOrElse("")), new ScriptReader(String.valueOf(commands.drop(1))))) : Result.empty();
        } catch (Exception e) {
            return Result.failure(e);
        }

    } // headOption muss eigentlich nicht genutzt werden, wenn mit einem Try und Catch gearbeitet wird.

    public List<String> toList() {
        return commands;
    }

    @Override
    public void shutdownInput() {

    }
}
