const API_URL = import.meta.env.VITE_API_URL || 'http://localhost:8080/api';

async function request(path, options = {}) {
  const response = await fetch(`${API_URL}${path}`, {
    headers: {
      'Content-Type': 'application/json',
      ...options.headers,
    },
    ...options,
  });

  if (!response.ok) {
    const message = await response.text();
    throw new Error(message || `Request failed with status ${response.status}`);
  }

  if (response.status === 204) {
    return null;
  }

  return response.json();
}

export function getTopics() {
  return request('/topics');
}

export function createTopic(title) {
  return request('/topics', {
    method: 'POST',
    body: JSON.stringify({ title }),
  });
}

export function updateTopicStatus(id, status) {
  return request(`/topics/${id}/status`, {
    method: 'PATCH',
    body: JSON.stringify({ status }),
  });
}

export function deleteTopic(id) {
  return request(`/topics/${id}`, {
    method: 'DELETE',
  });
}
