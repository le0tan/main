package seedu.algobase.logic.parser.problem;

import static seedu.algobase.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.algobase.logic.parser.CliSyntax.PREFIX_SORTING_METHOD;
import static seedu.algobase.logic.parser.CliSyntax.PREFIX_SORTING_ORDER;
import static seedu.algobase.logic.parser.ParserUtil.arePrefixesPresent;

import seedu.algobase.logic.commands.problem.SortCommand;
import seedu.algobase.logic.parser.ArgumentMultimap;
import seedu.algobase.logic.parser.ArgumentTokenizer;
import seedu.algobase.logic.parser.Parser;
import seedu.algobase.logic.parser.ParserUtil;
import seedu.algobase.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new SortCommand object.
 */
public class SortCommandParser implements Parser<SortCommand> {

    /**
     * Parses {@code userInput} into a command and returns it.
     *
     * @param userInput
     * @throws ParseException if {@code userInput} does not conform the expected format
     */
    @Override
    public SortCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argumentMultimap =
            ArgumentTokenizer.tokenize(userInput, PREFIX_SORTING_METHOD, PREFIX_SORTING_ORDER);

        if (!argumentMultimap.getPreamble().isBlank()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }

        if (!arePrefixesPresent(argumentMultimap, PREFIX_SORTING_METHOD)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }
        SortCommand.SortingMethod method =
            ParserUtil.parseSortingMethod(argumentMultimap.getValue(PREFIX_SORTING_METHOD).get());

        SortCommand.SortingOrder order;
        if (!arePrefixesPresent(argumentMultimap, PREFIX_SORTING_ORDER)) {
            // As specified in UG, ascending order is the default value.
            order = SortCommand.SortingOrder.ascend;
        } else {
            order = ParserUtil.parseSortingOrder(argumentMultimap.getValue(PREFIX_SORTING_ORDER).get());
        }

        return new SortCommand(method, order);
    }
}
