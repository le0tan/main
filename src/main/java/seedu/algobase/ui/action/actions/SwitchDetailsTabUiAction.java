package seedu.algobase.ui.action.actions;

import static seedu.algobase.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Optional;

import seedu.algobase.commons.core.index.Index;
import seedu.algobase.model.Model;
import seedu.algobase.model.gui.WriteOnlyTabManager;
import seedu.algobase.ui.UiActionException;
import seedu.algobase.ui.action.UiAction;
import seedu.algobase.ui.action.UiActionResult;

/**
 * Switches tab in the GUI.
 */
public class SwitchDetailsTabUiAction extends UiAction {

    public static final String MESSAGE_INVALID_TAB_INDEX = "Tab at index [%1$s] does not exist.";

    private Index modelIndex;

    public SwitchDetailsTabUiAction(Index modelIndex) {
        requireAllNonNull(modelIndex);
        this.modelIndex = modelIndex;
    }

    @Override
    public UiActionResult execute(Model model) throws UiActionException {
        try {
            WriteOnlyTabManager tabManager = model.getGuiState().getTabManager();
            tabManager.switchDetailsTab(modelIndex);
            return new UiActionResult(Optional.empty());
        } catch (IndexOutOfBoundsException exception) {
            throw new UiActionException(String.format(MESSAGE_INVALID_TAB_INDEX, modelIndex.getOneBased()));
        }
    }
}
