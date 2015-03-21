/**
 * Represents a set of change(s) made to a repository.
 * @author
 *
 */
public class ChangeSet {

	/* Queue of changes contained within the change set. */
	private final  QueueADT<Change> changes;

	/* The name of the repository to which the changes belongs. */
	private final String repoName;

	/**
	 * Constructs a change set object. 
	 * @param reponame The name of the repository.
	 * @throws IllegalArgumentException if any argument is null.
	 */
	public ChangeSet(String repoName) {
		
		this.repoName = repoName;
		this.changes = new SimpleQueue<Change>();
	}

	/**
	 * Adds (queues) a new change to the change set.
	 * @param doc The doc to which the change was done.
	 * @param type The type of the change.
	 * @throws IllegalArgumentException if any argument is null.
	 */
	public void addChange(Document doc, Change.Type type) {
		if (doc == null || type == null) {
			throw new IllegalArgumentException();
		}
		Change temp = new Change(doc, type);
		changes.enqueue(temp);
		
	}

	/**
	 * Returns the repository's name to which this change list belongs.
	 * @return The repository's name.
	 */
	public String getReponame() {
		return this.repoName;
	}

	/**
	 * Returns and removes the next change from the change set.
	 * @return The next change if present, null otherwise.
	 * @throws EmptyQueueException 
	 */
	public Change getNextChange() throws EmptyQueueException {
			return changes.dequeue();
	}

	/**
	 * Returns the count of changes contained in the change set.
	 * @return The count of changes.
	 */
	public int getChangeCount() {
		
		return changes.size();
		
	}

	@Override
	public String toString() {
		return this.changes.toString();	
	}
}