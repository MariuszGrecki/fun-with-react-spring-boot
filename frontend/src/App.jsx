import { useEffect, useState } from 'react';
import { createTopic, deleteTopic, getTopics, updateTopicStatus } from './api';
import './styles.css';

const statuses = ['TODO', 'IN_PROGRESS', 'DONE'];

export default function App() {
  const [topics, setTopics] = useState([]);
  const [title, setTitle] = useState('');
  const [isLoading, setIsLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    loadTopics();
  }, []);

  async function loadTopics() {
    try {
      setError('');
      setIsLoading(true);
      const data = await getTopics();
      setTopics(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setIsLoading(false);
    }
  }

  async function handleSubmit(event) {
    event.preventDefault();

    if (!title.trim()) {
      setError('Podaj nazwę tematu.');
      return;
    }

    try {
      setError('');
      const createdTopic = await createTopic(title.trim());
      setTopics((currentTopics) => [...currentTopics, createdTopic]);
      setTitle('');
    } catch (err) {
      setError(err.message);
    }
  }

  async function handleStatusChange(topicId, status) {
    try {
      setError('');
      const updatedTopic = await updateTopicStatus(topicId, status);
      setTopics((currentTopics) =>
        currentTopics.map((topic) => (topic.id === topicId ? updatedTopic : topic))
      );
    } catch (err) {
      setError(err.message);
    }
  }

  async function handleDelete(topicId) {
    try {
      setError('');
      await deleteTopic(topicId);
      setTopics((currentTopics) => currentTopics.filter((topic) => topic.id !== topicId));
    } catch (err) {
      setError(err.message);
    }
  }

  return (
    <main className="app">
      <header>
        <p>React + Spring Boot</p>
        <h1>Learning Tracker</h1>
      </header>

      <form className="topic-form" onSubmit={handleSubmit}>
        <label htmlFor="topic-title">Nowy temat</label>
        <div>
          <input
            id="topic-title"
            value={title}
            onChange={(event) => setTitle(event.target.value)}
            placeholder="Np. useEffect, REST Controller, JPA"
          />
          <button type="submit">Dodaj</button>
        </div>
      </form>

      {error && <p className="error">{error}</p>}
      {isLoading && <p>Ładowanie tematów...</p>}

      {!isLoading && (
        <section>
          <h2>Tematy</h2>

          {topics.length === 0 ? (
            <p>Brak tematów. Dodaj pierwszy temat nauki.</p>
          ) : (
            <ul className="topic-list">
              {topics.map((topic) => (
                <li key={topic.id}>
                  <span>{topic.title}</span>
                  <select
                    value={topic.status}
                    onChange={(event) => handleStatusChange(topic.id, event.target.value)}
                  >
                    {statuses.map((status) => (
                      <option key={status} value={status}>
                        {status}
                      </option>
                    ))}
                  </select>
                  <button type="button" onClick={() => handleDelete(topic.id)}>
                    Usuń
                  </button>
                </li>
              ))}
            </ul>
          )}
        </section>
      )}
    </main>
  );
}
