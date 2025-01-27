package seedu.algobase.logic.parser.task;

import static seedu.algobase.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.algobase.commons.core.index.Index;
import seedu.algobase.logic.commands.task.SetPlanCommand;
import seedu.algobase.logic.parser.Parser;
import seedu.algobase.logic.parser.ParserUtil;
import seedu.algobase.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new SetPlanCommand object
 */
public class SetPlanCommandParser implements Parser<SetPlanCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the SetPlanCommand
     * and returns a SetPlanCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public SetPlanCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new SetPlanCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetPlanCommand.MESSAGE_USAGE), pe);
        }
    }

}
